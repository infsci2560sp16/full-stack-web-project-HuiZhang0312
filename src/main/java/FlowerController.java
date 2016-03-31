package main;

public class FlowerController {
	public FlowerController(final FlowerService flowerService) {
    get("/flowers", new Route() {
      @Override
      public Object handle(Request request, Response response) {
        // process request
        return flowerService.getAllFlowers();
      }
    });
	}
}
