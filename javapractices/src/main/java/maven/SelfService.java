package maven;

import org.apache.maven.shared.invoker.MavenInvocationException;
import org.eclipse.jgit.api.errors.GitAPIException;

import java.io.IOException;
import java.net.URISyntaxException;

public class SelfService {

    public static void main(String[] args) throws MavenInvocationException, IOException, URISyntaxException, GitAPIException {

        // generate endpoint project - command : rugs create-endpoint endpoint-name
        //TODO : take input from user for endpoint name to be created
        RunningMvnCmd.runMvnCmd();

        // command : rugs create-repo org token
        JgitExample jgit = new JgitExample();
        //initialize local repo
        jgit.initLocal();

        //TODO : take input from user about org name : username or RUGS-Applications
        //TODO : check if repo already exists , throw a Exception RepoAlreadyExists
        //create remote repo


        JgitCreateRepo jgitCreateRepo = new JgitCreateRepo();
        jgitCreateRepo.createRemoteRepo();

        //push to repo specified
        jgit.initRemote();




    }
}
