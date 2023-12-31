package maven;


import org.eclipse.jgit.api.Git;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;

import org.eclipse.jgit.transport.*;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class JgitExample {


    public static void main(String[] args) throws IOException, GitAPIException, URISyntaxException  {

        JgitExample jgit = new JgitExample();
        jgit.initLocal();
        jgit.initRemote();
    }


    public void initLocal() throws IOException, URISyntaxException {
        Path path = Paths.get("/Users/sjari/projects/RUGS/endpointSample/sample/");
        try {
            Git git = Git.init().setDirectory(path.toFile()).call();
            git.add().addFilepattern(".").call();
            git.commit().setMessage("init repo").setAll(true).call();
            git.branchCreate().setForce(true).setName("master").call();
            git.commit().setMessage("creating  branch").call();
        } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }

    public void initRemote() throws GitAPIException {
        File localpath = new File("/Users/sjari/projects/RUGS/endpointSample/sample/");
        Git gitnew =Git.init().setDirectory(localpath).call();
        try {
            List<Ref> call = gitnew.branchList().call();

            for(Ref ref : call ){
                int i = 1;
//                System.out.println("Shivam" + i);
                i++;
                gitnew = Git.init().setDirectory(localpath).call();
                gitnew.remoteAdd().setUri(new URIish("https://github.paypal.com/sjari/sample.git")).setName("origin").call();
                gitnew.push()
                        .setRemote("https://github.paypal.com/sjari/sample.git")
                        .setCredentialsProvider(new UsernamePasswordCredentialsProvider("sjari@paypal.com","cbc6638195cfe7f1a83052951ca4550687d41cc6" ))
                        .setPushAll().add(".").call();
            }

        } catch (GitAPIException | URISyntaxException e) {
            e.printStackTrace();
        }

    }







}


