package pairmatching;

import pairmatching.controller.FileController;
import pairmatching.controller.MatchingController;
import pairmatching.model.CrewManager;
import pairmatching.model.MissionManager;

public class Application {
    public static void main(String[] args) {
        CrewManager crewManager = new CrewManager();
        MissionManager missionManager = new MissionManager();

        FileController fileController = new FileController(crewManager, missionManager);
        MatchingController matchingController = new MatchingController(crewManager, missionManager);

        fileController.initializeData("src/main/resources/backend-crew.md", "src/main/resources/frontend-crew.md");
        matchingController.startMatching();
    }
}
