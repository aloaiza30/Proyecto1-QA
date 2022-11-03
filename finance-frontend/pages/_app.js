import "bootstrap/dist/css/bootstrap.min.css"; // Import bootstrap CSS
import "../styles/globals.css";

import App from 'next/app';
import Router from 'next/router';
import UserContext from '../components/UserContext';

export default class MyApp extends App {
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

  signIn = (jsonData) => {
    localStorage.setItem('id', jsonData.id);
    localStorage.setItem('userName', jsonData.userName);
    localStorage.setItem('lastName', jsonData.lastName);
    localStorage.setItem('email', jsonData.email);
    localStorage.setItem('monthlyEarnings', jsonData.monthlyEarnings);
    localStorage.setItem('categories', JSON.stringify(jsonData.categories));
    localStorage.setItem('payments', JSON.stringify(jsonData.payments));
    localStorage.setItem('savings', JSON.stringify(jsonData.savings));
    localStorage.setItem('wishlist', JSON.stringify(jsonData.wishlist));

    this.setState(
      {
        id: jsonData.id,
        userName: jsonData.userName,
        lastName: jsonData.lastName,
        email: jsonData.email,
        monthlyEarnings: jsonData.monthlyEarnings,
        categories: jsonData.categories,
        payments: jsonData.payments,
        savings: jsonData.savings,
        wishlist: jsonData.wishlist,
      },
      () => {
        Router.push('/report');
      }
    );
  };

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
