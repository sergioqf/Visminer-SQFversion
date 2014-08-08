import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.kohsuke.github.GHRepository;
import org.visminer.git.remote.GitHub;
import org.visminer.git.remote.IssueUpdate;
import org.visminer.git.remote.MilestoneUpdate;
import org.visminer.main.VisMiner;
import org.visminer.model.Milestone;
import org.visminer.persistence.RepositoryDAO;

import GUI.DbDialog;
import data_base.DbOracle;
import data_base.IDbDAO;
import data_base.SgbdCreator;


public class Main {
	
	
		
	public static void main(String[] args) throws IOException, GitAPIException {
		
		JFrame frame = null;
		DbDialog dbdialog = new DbDialog(frame,true);
		dbdialog.setVisible(true);
		IDbDAO idb = SgbdCreator.create(dbdialog.getDb());
		String db = idb.setDb();
		String url= idb.setUrl();
		
		Map<String, String> props = new HashMap<String, String>(5);
		props.put(PersistenceUnitProperties.JDBC_DRIVER, db);

		props.put(PersistenceUnitProperties.JDBC_URL, url+dbdialog.getUrl());
		props.put(PersistenceUnitProperties.JDBC_USER, dbdialog.getUser());
		props.put(PersistenceUnitProperties.JDBC_PASSWORD, dbdialog.getPassword()); 	
		props.put(PersistenceUnitProperties.DDL_GENERATION, "create-tables");
		

		Map<Integer, String> api_cfg_local = new HashMap<Integer, String>(3);
		api_cfg_local.put(VisMiner.LOCAL_REPOSITORY_PATH,
				"/path/.git");
		

		api_cfg_local.put(VisMiner.LOCAL_REPOSITORY_NAME, "visminer");
		api_cfg_local.put(VisMiner.LOCAL_REPOSITORY_OWNER, "visminer");
		
		/*
		 * These isn't obligatory, all parameters of "api_cfg_remote" could be
		 * set how null.	
		 */
		Map<Integer, Object> api_cfg_remote = new HashMap<Integer, Object>(3);
		api_cfg_remote.put(VisMiner.REMOTE_REPOSITORY_LOGIN, null);
		api_cfg_remote.put(VisMiner.REMOTE_REPOSITORY_PASSWORD, null);
		
		/*
		 * Object that implements the interface Connection, this object
		 * is some remote repository that works with git.
		 */
		api_cfg_remote.put(VisMiner.REMOTE_REPOSITORY_GIT, new GitHub());
				
		VisMiner visminer = new VisMiner(props, api_cfg_local, api_cfg_remote);
	
		System.out.print(visminer.getMetric("NOP").getDescription());

		
	}
	
}