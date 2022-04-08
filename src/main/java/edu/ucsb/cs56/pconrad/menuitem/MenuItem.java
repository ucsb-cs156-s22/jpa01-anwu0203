package edu.ucsb.cs56.pconrad.menuitem;

public class MenuItem {

    private String name;
    private int priceInCents;
    private String category;

    /**
     * Custom exception thrown when getPrice is called with a width
     * that is too narrow for the formatted price.
     */

    public static class TooNarrowException extends RuntimeException {
    }


    public MenuItem(String name, int priceInCents, String category) {
        this.name = name;
        this.priceInCents = priceInCents;
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Returns the price, formatted as a string with a $.
     * For example "$0.99", "$10.99", or "$3.50"
     */

    public String getPrice() {
        int dollars = this.priceInCents / 100;
        int cents = this.priceInCents % 100;
        return "$" + dollars + "." + cents;
    }

    /**
     * Returns the price, formatted as a string with a $,
     * right justified in a field with the specified width.
     * For example "$0.99", "$10.99", or "$3.50".
     * <p>
     * If the width is too small, throws TooNarrowException
     *
     * @param width width of returned string
     */

    public String getPrice(int width) {
        int dollars = this.priceInCents / 100;
        int cents = this.priceInCents % 100;
        String rStr = "$" + dollars + "." + cents;
        int diff = width - rStr.length();
        if (diff < 0){
            throw new TooNarrowException();
        } else {
            for(int i = 0; i < diff; i++){
                rStr = " " + rStr;
            }
        }
        return rStr;
    }

    public int getPriceInCents(){
        return this.priceInCents;
    }

    /**
     * return a string in csv format, in the order name,price,cateogry.
     * For example <code>Small Poke Bowl,1049,Poke Bowls</code>
     *
     * @return string in csv format
     */

    @Override
    public String toString() {
        return this.name + "," + this.priceInCents + "," + this.category;
    }

}
