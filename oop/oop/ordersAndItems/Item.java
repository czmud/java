public class Item {
    private String name;
    private Double price;
    private Integer index;

    public Item( String name, Double price, Integer index){
        this.name = name;
        this.price = price;
        this.index = index;
    }



    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
    public Integer getIndex(){
        return index;
    }
    public void setName( String name ){
        this.name = name;
    }
    public void setPrice( double price ){
        this.price = price;
    }
    public void setIndex( Integer index ){
        this.index = index;
    }

}