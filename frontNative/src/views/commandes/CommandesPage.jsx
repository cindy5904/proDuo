import React from 'react';
import {View} from "react-native";
import Hero from "../../components/Hero";
import Commandes from "../../assets/image/Pages/Commandes.png"

function CommandesPage(props) {
    return (
        <View>
            <Hero title={"Commandes"} bgImg={Commandes}/>
        </View>
    );
}

export default CommandesPage;