import React from 'react';
import {ScrollView, StyleSheet, View} from "react-native";
import Hero from "../../components/Hero";
import Vetement from "../../assets/image/Pages/Vetements.png"
import ProfilFemme from "../../assets/image/Cards/ProfilFemme.png"
import ProfilHomme from "../../assets/image/Cards/ProfilHomme.png"
import ProfilEnfant from "../../assets/image/Cards/ProfilEnfant.png"
import ProfilBebe from "../../assets/image/Cards/ProfilBebe.png"

import Cards from "../../components/Cards";

function VetementPage({navigation}) {

    const allCategories = [
        {
            id: 1,
            title: "Femme",
            bgImg: ProfilFemme,
            url: "Vêtements"
        },
        {
            id: 2,
            title: "Homme",
            bgImg: ProfilHomme,
            url: "Vêtements"
        },
        {
            id: 3,
            title: "Enfant",
            bgImg: ProfilEnfant,
            url: "Vêtements"
        },
        {
            id: 4,
            title: "Bébé",
            bgImg: ProfilBebe,
            url: "Vêtements"
        }
    ]

    return (
        <View>
            <Hero title={"Vêtements"} bgImg={Vetement} navigation={navigation}/>
            <View contentContainerStyle={styles.contentContainer} >
                <Cards data={allCategories} title={"Categories"}/>
            </View>
        </View>
    );
}

export default VetementPage;

const styles = StyleSheet.create({
    contentContainer : {
        paddingTop : 50,
        alignItems :"center",
        justifyContent : "center"
    }
})
