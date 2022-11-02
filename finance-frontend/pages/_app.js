import "bootstrap/dist/css/bootstrap.min.css"; // Import bootstrap CSS
import "../styles/globals.css";

import App from 'next/app';
import Router from 'next/router';
import UserContext from '../components/UserContext';

import { useEffect } from "react";

export default class MyApp extends App {
  state = {
    id: null,
    name: null,
    lastname: null,
    email: null,
    monthlyEarnings: null,
    categories: null,
    payments: null,
    savings: null,
    wishlist: null,
  };

  componentDidMount = () => {
    const email = localStorage.getItem(email);
    if (email) {
      this.setState({
        email
      });
    } else if (!Router.pathname == "/register") {
      Router.push('/login');
    }
  };

  signIn = (jsonData) => {
    localStorage.setItem('id', jsonData.id);
    localStorage.setItem('name', jsonData.name);
    localStorage.setItem('lastname', jsonData.lastName);
    localStorage.setItem('email', jsonData.email);
    localStorage.setItem('monthlyEarnings', jsonData.monthlyEarnings)

    this.setState(
      {
        id: jsonData.id,
        name: jsonData.name,
        lastname: jsonData.lastName,
        email: jsonData.email,
        monthlyEarnings: jsonData.monthlyEarnings,
      },
      () => {
        Router.push('/report');
      }
    );
  };

  signOut = () => {
    localStorage.clear();
    this.setState({
      id: null,
      name: null,
      lastname: null,
      email: null,
      monthlyEarnings: null,
      categories: null,
      payments: null,
      savings: null,
      wishlist: null,
    });
    Router.push('/login');
  };

  render() {
    const { Component, pageProps } = this.props;

    return (
      <UserContext.Provider value={{ id: this.state.id, username: this.state.username, lastname: this.state.lastname,
                                     email: this.state.email, monthlyEarnings: this.state.monthlyEarnings, categories: this.state.categories,
                                     payments: this.state.payments, savings: this.state.savings, wishlist: this.state.wishlist, 
                                     signIn: this.signIn, signOut: this.signOut}}>
        <Component {...pageProps} />
      </UserContext.Provider>
    );
  }
}

// function MyApp({ Component, pageProps }) {

//   return <Component {...pageProps} />
// }

// export default MyApp
