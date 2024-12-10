package pairmatching;

import pairmatching.controller.FileController;
import pairmatching.controller.MatchingController;
import pairmatching.model.MissionManager;
import pairmatching.model.crewManager.BackendManager;
import pairmatching.model.crewManager.FrontendManager;

public class Application {
    public static void main(String[] args) {
        BackendManager backendManager = new BackendManager();
        FrontendManager frontendManager = new FrontendManager();
        MissionManager missionManager = new MissionManager();

        FileController fileController = new FileController(backendManager, frontendManager, missionManager);
        MatchingController matchingController = new MatchingController(backendManager, frontendManager, missionManager);

        fileController.initializeData("src/main/resources/backend-crew.md", "src/main/resources/frontend-crew.md");
        matchingController.startMatching();
    }
}
