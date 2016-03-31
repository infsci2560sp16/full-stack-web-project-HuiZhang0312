package main;

public class FlowerController {
	public FlowerController(final FlowerService flowerService) {
    get("/flowers", (req, res) -> flowerService.getAllflowers());
	}
}
