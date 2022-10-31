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
    const user = localStorage.getItem(user);
    if (user) {
      this.setState({
        user
      });
    } else if (!Router.pathname == "/register") {
      Router.push('/login');
    }
  };

  signIn = (user) => {
    localStorage.setItem('user', username);

    this.setState(
      {
        userName: username
      },
      () => {
        Router.push('/report');
      }
    );
  };

  signOut = () => {
    localStorage.removeItem('user');
    this.setState({
      user: null
    });
    Router.push('/login');
  };

  render() {
    const { Component, pageProps } = this.props;

    return (
      <UserContext.Provider value={{ user: this.state.user, signIn: this.signIn, signOut: this.signOut}}>
        <Component {...pageProps} />
      </UserContext.Provider>
    );
  }
}

// function MyApp({ Component, pageProps }) {

//   return <Component {...pageProps} />
// }

// export default MyApp
