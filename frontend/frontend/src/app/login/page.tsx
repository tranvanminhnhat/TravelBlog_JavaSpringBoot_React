import React from "react";
import LoginComponent from "@/components/pages/Login";
import { NextPage } from "next";
import FooterComponent from "@/components/layouts/Footer";
import HeaderComponent from "@/components/layouts/Header";

const Login: NextPage = () => {
  return (
    <>
      <HeaderComponent></HeaderComponent>
      <LoginComponent></LoginComponent>
      <FooterComponent></FooterComponent>
    </>
  );
};

export default Login;
