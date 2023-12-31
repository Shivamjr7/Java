package maven;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;


import java.io.File;
import java.io.IOException;

public class JgitCreateRepo {

    private static final String oAuthToken = "cbc6638195cfe7f1a83052951ca4550687d41cc6";
    static String gitHubAPIURL = "https://github.paypal.com/api/v3";
    static GitHubClient gitClient = GitHubClient.createClient(gitHubAPIURL);

        static {
        /*
         * fix for Exception in thread "main" javax.net.ssl.SSLHandshakeException:
         * sun.security.validator.ValidatorException: PKIX path building failed:
         * sun.security.provider.certpath.SunCertPathBuilderException: unable to find
         * valid certification path to requested target
         */
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                System.out.println("Certificate done");
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }

        } };

        SSLContext sc;
        try {
            sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Create all-trusting host name verifier
        HostnameVerifier allHostsValid = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        };
        // Install the all-trusting host verifier
        HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        /*
         * end of the fix
         */

        gitClient.setOAuth2Token(oAuthToken);


    }
    private static RepositoryService repoService = null;
    public static void main(String[] args) throws GitAPIException, IOException {


//        repoService.getRepository("sjari","himalaya");


    }


    public void createRemoteRepo() throws IOException {
        repoService = new RepositoryService(gitClient);
        repoService.createRepository(new Repository().setName("sample").setPrivate(true) );
    }


    public boolean checkRepoExists() throws IOException {
      boolean repoExists =   (null != repoService.getRepository("sjari", "himalaya")) ?  true :  false ;
      return repoExists;
    }
}
