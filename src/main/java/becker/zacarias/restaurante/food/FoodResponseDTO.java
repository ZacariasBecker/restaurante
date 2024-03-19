package becker.zacarias.restaurante.food;

public record FoodResponseDTO(String id, String name, String image, Double price) {
	public FoodResponseDTO(Food food) {
		this(food.getId(), food.getName(), food.getImage(), food.getPrice());
	}
}
