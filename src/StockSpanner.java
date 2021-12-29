import java.util.Stack;

public class StockSpanner {


    Stack<Price> stackOfPrices;
    int counter ;
    public StockSpanner() {
        stackOfPrices = new Stack<>();
        counter = 0;

    }

    public int next(int price) {
        while(!stackOfPrices.isEmpty() && stackOfPrices.peek().price <= price) {
            stackOfPrices.pop();
        }
        counter++;
        int ans = stackOfPrices.isEmpty()? counter: counter-stackOfPrices.peek().index;
        stackOfPrices.push(new Price(price, counter));
        return ans;
    }

    public class Price {
        int price;
        int index;

        public Price(int price, int index) {
            this.index = index;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        StockSpanner sp = new StockSpanner();

        sp.next(31);
        sp.next(41);
        sp.next(48);
        sp.next(59);
        sp.next(79);


    }
}
