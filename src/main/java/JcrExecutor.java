import org.exoplatform.container.ExoContainer;
import org.exoplatform.container.ExoContainerContext;
import org.exoplatform.services.jcr.RepositoryService;
import org.exoplatform.services.rest.resource.ResourceContainer;

import javax.jcr.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by exo on 04/10/16.
 */
@Path("/extensions/nodes/")
public class JcrExecutor implements ResourceContainer {

    @GET
    @Path("/addnode")
    public void addNode() {

      //  StringBuilder sb = new StringBuilder();

        try {
            ExoContainer myContainer = ExoContainerContext.getCurrentContainer();

            RepositoryService repositoryService = (RepositoryService) myContainer.getComponentInstanceOfType(RepositoryService.class);
           // Repository repository = repositoryService.getRepository("repository");


           // Credentials credentials = new SimpleCredentials("root", "gtn".toCharArray());

            Session mySession = repositoryService.getCurrentRepository().getSystemSession("collaboration");

            Node root = mySession.getRootNode();

           // Node myNode = root.getNode("test");
            Node newNode = root.addNode("trainingNode", "tn:trainningnew");

            newNode.setProperty("tn:id", "hello");
            newNode.setProperty("tn:name","word");
            mySession.save();


        } catch (Exception ex) {
            Logger.getLogger(JcrExecutor.class.getName()).log(Level.SEVERE, null, ex);
         //   sb.append(ex.getMessage());
        }


    }
}




