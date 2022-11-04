/* This is importing the bootstrap css file, the global css file, the App component, the Router
component, and the UserContext component. */
import "bootstrap/dist/css/bootstrap.min.css";

import App from 'next/app';
import Router from 'next/router';
import UserContext from '../components/UserContext';

/* Exporting the class MyApp as the default export. */
export default class MyApp extends App {
  /* Setting the initial state of the app. */
  state = {
    id: 0,
    userName: '',
    lastName: '',
    email: '',
    monthlyEarnings: 0,
    categories: [],
    payments: [],
    savings: {},
    wishlist: [],
  };

  /* This is checking if the user is logged in. If they are, it sets the state of the app to the user's
  information. If they are not, it redirects them to the login page. */
  componentDidMount = () => {
    //const email = localStorage.getItem(id);
    if (localStorage.getItem("id")) {
      this.setState({
        id: localStorage.getItem("id"),
        userName: localStorage.getItem("userName"),
        lastName: localStorage.getItem("lastName"),
        email: localStorage.getItem("email"),
        monthlyEarnings: localStorage.getItem("monthlyEarning"),
        categories: JSON.parse(localStorage.getItem("categories")),
        payments: JSON.parse(localStorage.getItem("payments")),
        savings: JSON.parse(localStorage.getItem("savings")),
        wishlist: JSON.parse(localStorage.getItem("wishlist")),
      });
    } else if (!(Router.pathname == '/login') && !(Router.pathname == '/register') && !(Router.pathname == '/')) {
      Router.push('/login');
    }
  };

  /* This is setting the state of the app to the user's information. */
  signIn = (jsonData) => {
    localStorage.setItem('id', jsonData.id);
    localStorage.setItem('userName', jsonData.userName);
    localStorage.setItem('lastName', jsonData.lastName);
    localStorage.setItem('email', jsonData.email);
    localStorage.setItem('monthlyEarnings', jsonData.monthlyEarnings);
    localStorage.setItem('categories', jsonData.categories ? JSON.stringify(jsonData.categories) : []);
    localStorage.setItem('payments', jsonData.payments ? JSON.stringify(jsonData.payments) : []);
    localStorage.setItem('savings', jsonData.savings ? JSON.stringify(jsonData.savings) : {});
    localStorage.setItem('wishlist', jsonData.wishlist ? JSON.stringify(jsonData.wishlist) : []);

    this.setState(
      {
        id: jsonData.id,
        userName: jsonData.userName,
        lastName: jsonData.lastName,
        email: jsonData.email,
        monthlyEarnings: jsonData.monthlyEarnings,
        categories: jsonData.categories ? jsonData.categories : [],
        payments: jsonData.payments ? jsonData.payments : [],
        savings: jsonData.savings ? jsonData.savings : {},
        wishlist: jsonData.wishlist ? jsonData.wishlist : [],
      },
      () => {
        Router.push('/report');
      }
    );
  };

  /* This is the signOut function. It is redirecting the user to the login page, clearing the local
  storage, and setting the state of the app to the initial state. */
  signOut = () => {
    Router.push('/login');
    localStorage.clear();
    this.setState({
      id: 0,
      userName: '',
      lastName: '',
      email: '',
      monthlyEarnings: 0,
      categories: [],
      payments: [],
      savings: {},
      wishlist: [],
    });
  };

  /**
   * The render function is a function that returns the component that is being rendered
   * @returns The component that is being rendered is the component that is being passed in as a prop.
   */
  render() {
    const { Component, pageProps } = this.props;

    return (
      <UserContext.Provider value={{ id: this.state.id, userName: this.state.userName, lastName: this.state.lastName,
                                     email: this.state.email, monthlyEarnings: this.state.monthlyEarnings, categories: this.state.categories,
                                     payments: this.state.payments, savings: this.state.savings, wishlist: this.state.wishlist, signIn: this.signIn, 
                                     signOut: this.signOut, restoreInfo: this.restoreInfo}}>
        <Component {...pageProps} />
      </UserContext.Provider>
    );
  }
}

// function MyApp({ Component, pageProps }) {

//   return <Component {...pageProps} />
// }

// export default MyApp
