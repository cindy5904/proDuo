import React from 'react';
import {View} from "react-native";
import Hero from "../components/Hero";
import Panier from "../assets/image/Pages/Panier.png"

function PanierPage(props) {
    return (
        <View>
            <Hero title={"Panier"} bgImg={Panier}/>
        </View>
    );
}

export default PanierPage;