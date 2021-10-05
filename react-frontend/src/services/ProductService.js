import axios from 'axios';
const PRODUCT_API_LISTPRODUCT="http://localhost:8080/api/products";
const PRODUCT_API_ADD ="http://localhost:8080/api/product";

class ProductService {

    getProducts(){
        return axios.get(PRODUCT_API_LISTPRODUCT);
    }

    addProduct(product){
        return axios.post(PRODUCT_API_ADD,product);
    }
    
}
export default new ProductService()