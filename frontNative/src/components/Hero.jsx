import React from 'react';
import {ImageBackground, Text, View} from "react-native";
import heroStyle from "../assets/styles/components/Hero";

function Hero({title, bgImg}) {
    return (
        <ImageBackground source={bgImg}>
            <View style={heroStyle.container}>
                <Text style={heroStyle.text}>{title}</Text>
            </View>
        </ImageBackground>
    );
}


export default Hero;