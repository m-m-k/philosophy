import React from 'react';
import {Form, Button, FormControl, FormGroup, ControlLabel, Navbar} from 'react-bootstrap';


class App extends React.Component {
  constructor() {
    super();
    this.state = {
      value: '',
      path:[],
      found: false
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.getData = this.getData.bind(this);

  }

  handleChange(event) {
    this.setState({value: event.target.value.replace("https://en.wikipedia.org/wiki/", "")});
  }

  handleSubmit(event) {
    this.getData();
    event.preventDefault();
  }

  getData() {
    fetch('/v1/api/' + this.state.value)
      .then(result => result.json())
      .then(res => this.setState({path: res.path, found: res.found, loop: res.loop, page: res.page, count: res.count}))

      console.log(this.state.path);
  }

  isFound() {
     if(this.state.found) {
       return(
         <div>
           <h3>You Found Philosophy!</h3>
           <h4>Hops: {this.state.count}</h4>
           <h4>Path: </h4>
         </div>
           )
     } else { 
       if(this.state.loop) {
         return(<h3>Loop found</h3>)
       }else {
         if(this.state.page){
          return(<h3>Unable to Find Page</h3>)
       }
       }
     }
  }


  render () {

    return (

        <div>
            <Navbar brand="Matt" fixedTop inverse>
              <Navbar.Header>
                <Navbar.Brand>
                  <strong>Getting to Philosophy</strong>
                </Navbar.Brand>
              </Navbar.Header>
            </Navbar>
            <div>
              <form onSubmit={this.handleSubmit}>
              <label>
              Enter a page:
              <input type="text" value={this.state.value} onChange={this.handleChange} />
              </label>
              <input type="submit" value="Submit" />
              </form>
            </div>
            {this.isFound()}
        {this.state.path.map(path => 
            <div> {path} </div>)}
        </div>
        );
  }

}

export default App;
