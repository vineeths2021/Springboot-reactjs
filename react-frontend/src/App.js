
import './App.css';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom'
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListComponent from './components/ListComponent';
import AddProductComponent from './components/AddProductComponent';

function App() {
  return (
    <div>
      <Router>
       
          <HeaderComponent/>
            <div className="container">
              <Switch>{/*http://localhost:3000/ */}
                <Route path="/" exact component={ListComponent}></Route>
                <Route path="/products" component={ListComponent}></Route>
                <Route path="/add-product" component={AddProductComponent}></Route>
                
              </Switch>
            </div>
          <FooterComponent/>
        
      </Router>
    </div>
    
  );
}

export default App;
