package parser;

public class Parser {

    public static void main(String[] args) {

        //TODO create a snippet in jshell
        String data = "nova.Nova2Compliance:false:177024501258150:177024501273984|nova.NovaV1ToComplianceV1HeaderPayloadManipulator:false:177024501177631:177024501200368|nova.Start:177024501012207:177024501012351|nova.FPTIBizLogging:false:177026390069450:177026390565991|nova.NovaV1ToLimitsV1HeaderPayloadManipulator:false:177024501229066:177024501278243|nova.FPTI:true:177026854581908:177026859653528|nova.UnifiedLogging:false:177026829587171:177026835748970|nova.Nova2Remediation:false:177024501180129:177024501471479|nova.End:false:177026819211641:177026819216796|nova.RemediationValidator:false:177024501143524:177024501155383|nova.Limits:true:177024501644962:177024621200056|nova.FPTITransform:false:177026800864365:177026802161890|nova.BizLogging:false:177026379564065:177026382188771|nova.Compliance:true:177024502230464:177024589035765|nova.NovaV1ToRiskV1HeaderPayloadManipulator:false:177024501120560:177024501149487|nova.novaSubDiagraph:true:177024500912133:177026839369742|nova.RiskRaptor:true:177024503263201:177025757765110|nova.NovaV1ToStandInV1HeaderPayloadManipulator:false:177024501312588:177024501339133|nova.StandIn:true:177024501498994:177024549973795|nova.NovaConsolidator:false:177026368429009:177026379485207|nova.Nova2Limit:false:177024501408987:177024501499187|nova.Nova2Risk:false:177024501078140:177024501264710";


        parseNodes(data);

    }


    static void parseNodes(String data)
    {
       String[] dataArray = data.split("\\|");

        for (String s : dataArray) {
            String[] endpointInfo = s.split(":");

            int n = endpointInfo.length;

            if(endpointInfo[0].equalsIgnoreCase("nova.FPTI"))
                continue;

            Long startTime = Long.parseLong(endpointInfo[n - 2]);
            Long endTime = Long.parseLong(endpointInfo[n - 1]);

            long diff = endTime - startTime;
            double lat = (double) diff / 1_000_000;
            System.out.println("Node : " + endpointInfo[0] + " time took : " + lat +" ms");
        }
    }
}
