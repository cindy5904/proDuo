import React from 'react';
import {View} from "react-native";
import Hero from "../components/Hero";
import Home from "../assets/image/Pages/Home.png"


function LogPages(props) {
    return (
        <View>
            <Hero title={"Login"} bgImg={Home} />
        </View>
    );
}

export default LogPages;