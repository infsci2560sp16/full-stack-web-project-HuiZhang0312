import static spark.Spark.*;
import spark.*;

public class FlowerController {
	public UserController(final FlowerService flowerService){
		get("/flowers", new Route(){
			@Override
			public Object handle(Request request, Response response){
				return  flowerService.getAllFlowers();
			}
		});
	}
}
