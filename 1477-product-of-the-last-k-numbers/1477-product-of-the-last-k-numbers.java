class ProductOfNumbers {
    ArrayList<Integer> product;
    public ProductOfNumbers() {
        product = new ArrayList<>();
        product.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            product.clear();
            product.add(1);
        }else{
            product.add(product.getLast() * num);
        }
    }
    
    public int getProduct(int k) {
        if(k + 1 > product.size()){
            return 0;
        }
        return product.getLast() / product.get(product.size() - k - 1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */