import React, { Component } from 'react';
import ProductService from '../services/ProductService';

class ListComponent extends Component {
    constructor(props){
        super(props)
            this.state={
                products:[]
            }
            {/* Binding to Event handler , see event handlers in react */}
            this.addProduct=this.addProduct.bind(this);
        }
    componentDidMount(){
        ProductService.getProducts().then((res)=>{
            this.setState({products:res.data});
           
        }).catch(function (ex) {
            console.log('Response parsing failed. Error: ', ex);
        });
        console.log(this.state.products);
    }
      /*Event handler method */
    addProduct(){
this.props.history.push('/add-product');
    }
    render() {
        return (
            <div>
                <h2 className="text-center p-3 mb-2 bg-info text-white">Product List</h2>
                <div className="col">
                    <button className="btn btn-primary" onClick={this.addProduct}>Add Product</button>
                </div>
                    <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Product Name</th>
                                <th>Product Description</th>
                                <th>Product Rate</th>
                                <th>Product Type</th>
                                <th>Product Manufacure Date</th>
                                <th>Product Expiry Date</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.products.map(
                                    product=>
                                    <tr key ={product.productid}>
                                         <td>{product.productname}</td>
                                         <td>{product.productdescription}</td>    
                                         <td>{product.productrate}</td>  
                                         <td>{product.producttype}</td>  
                                         <td>{product.manufacturedate}</td>   
                                         <td>{product.expirydate}</td>     
                                     </tr>   
                                )
                            }
                        </tbody>

                    </table>

                </div>
            </div>
        );
    }
}

export default ListComponent;