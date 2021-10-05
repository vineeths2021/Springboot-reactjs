import React, { Component } from 'react';
import ProductService from '../services/ProductService';

class UpdateProductComponent extends Component {
    constructor(props){
        super(props)
        this.state={
            productid: this.props.match.params.id,
            productname:'',
            productrate:'',
            productdescription:'',
            expirydate:'',
            manufacturedate:'',
            producttype:null
        }
        this.changeProductNameHandler=this.changeProductNameHandler.bind(this);
        this.changeProductRateHandler=this.changeProductRateHandler.bind(this);
        this.changeProductTypeHandler=this.changeProductTypeHandler.bind(this);
        this.changeProductDescriptionHandler=this.changeProductDescriptionHandler.bind(this);
        this.changeExpiryDateHandler=this.changeExpiryDateHandler.bind(this);
        this.changeManufactureDateHandler=this.changeManufactureDateHandler.bind(this);
        this.updateProduct=this.updateProduct.bind(this);
    }
    componentDidMount(){
        ProductService.getProduct(this.state.productid).then( (res) => {
                let product=res.data;
                this.setState({productname: product.productname,
                productrate: product.productrate,
                producttype:product.producttype,
                productdescription:product.productdescription,
                expirydate:product.expirydate,
                manufacturedate:product.expirydate
                });
        });
    }
    updateProduct = (e) => {
        e.preventDefault();
        let product={productname:this.state.productname,productrate:this.state.productrate,producttype:this.state.producttype,productdescription:this.state.productdescription,expirydate:this.state.expirydate,manufacturedate:this.state.manufacturedate};
        console.log("product:"+JSON.stringify(product));
        ProductService.updateProduct(product,this.state.productid).then(res =>{
        this.props.history.push('/products');
        });
    }
    changeProductNameHandler=(event)=>{
        this.setState({productname: event.target.value});
    }
    changeProductRateHandler=(event)=>{
        this.setState({productrate: event.target.value});
    }
    changeProductTypeHandler=(event)=>{
        this.setState({producttype: event.target.value});
    }
    changeProductDescriptionHandler=(event)=>{
        this.setState({productdescription: event.target.value});
    }
    changeExpiryDateHandler=(event)=>{
        this.setState({expirydate: event.target.value});
    }
    changeManufactureDateHandler=(event)=>{
        this.setState({manufacturedate: event.target.value});
    }
    cancel(){
        this.props.history.push('/products');
    }
    render() {
        return (
            <div>
              
                <div className="container">
                    <div className ="row">
                        <div className="card col-md-12 offset-md-6 offset-md"> </div>
                        <h3 className="text-center">Update Product</h3>
                        <div className="card-body">

                            <form>
                                <div className="form-group">
                                    <label>Product Name</label>
                                    <input placeholder="Product Name" name="productname" className="form-control"
                                     value={this.state.productname} onChange={this.changeProductNameHandler}/>

                                </div>
                                <div className="form-group">
                                    <label>Product Rate</label>
                                    <input placeholder="0.0" name="productrate" className="form-control"
                                     value={this.state.productrate} onChange={this.changeProductRateHandler}/>

                                </div>
                                <div className="form-group">
                                    <label>Product Type</label>
                                    <select className="form-control" name="producttype" onChange={this.changeProductTypeHandler}>
                                      
                                        <option value="AUTOMOBILE">AUTOMOBILE</option>
                                        <option value="EDIBLE">EDIBLE</option>
                                        <option value="MANUFACTURE">MANUFACTURE</option>
                                        <option value="HEALTHCARE">HEALTHCARE</option>
                                        <option value="ELECTRONICS">ELECTRONICS</option>
                                    </select>

                                </div>
                                <div className="form-group">
                                    <label>Product Description</label>
                                    <input placeholder="Product Description" name="productdescription" className="form-control"
                                     value={this.state.productdescription} onChange={this.changeProductDescriptionHandler}/>

                                </div>
                               
                                <div className="form-group">
                                    <label>Product Expiry Date</label>
                                    <input placeholder="YYYY-MM-DD" name="expirydate" className="form-control"
                                     value={this.state.expirydate} onChange={this.changeExpiryDateHandler}/>

                                </div>
                                <div className="form-group">
                                    <label>Product Manufacture Date</label>
                                    <input placeholder="YYYY-MM-DD" name="manufacturedate" className="form-control"
                                     value={this.state.manufacturedate} onChange={this.changeManufactureDateHandler}/>

                                </div>
                                <button className="btn btn-success" onClick={this.updateProduct}>Update</button>
                                <button className="btn btn-danger" onClick={this.cancel.bind(this)} >Cancel</button>
                            </form>
                        </div>
                   </div>

                </div>
            </div>
        );
    }
}

export default UpdateProductComponent;