class Main
{
    public static void main(String[] args) {
        GroceryStore store = new GroceryStore();
        List<? super Fruit> fruitsBasket = new ArrayList<>();
        store.fill(fruitsBasket);

        assert(fruitsBasket.size() == 3);

        List<Apple> anotherBasket = new ArrayList<>();
        anotherBasket.add(new Apple("apple", 5, "US"));
        anotherBasket.add(new Apple("apple", 8, "UK"));
        anotherBasket.add(new Apple("apple", 9, "CN"));

        assert(store.getBiggestFruit(anotherBasket).getSize() == 9);
    }
}