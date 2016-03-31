import static spark.Spark.*;
import spark.*;

public class FlowerController {
	public FlowerController(final FlowerService flowerService) {
    get("/flowers", (req, res) -> flowerService.getAllflowers());
	}
}
