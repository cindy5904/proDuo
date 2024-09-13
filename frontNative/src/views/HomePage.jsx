import React from 'react'
import {
    Button,
    FlatList,
    Image,
    SafeAreaView,
    ScrollView,
    StyleSheet,
    Text,
    Touchable,
    TouchableOpacity,
    View
} from 'react-native'
import Home from "../assets/image/Pages/Home.png"
import Hero from "../components/Hero";
import VetementsIcon from "../assets/image/Icons/VetementsIcons.png"
import PanierIcon from "../assets/image/Icons/PanierIcons.png"
import LivraisonIcon from "../assets/image/Icons/LivraisonIcons.png"

export default function HomePage({navigation}) {

    const liensNavigation = [
        {
            id: 1,
            title: "Vêtements",
            icon: VetementsIcon,
            url: "Vêtements",
        },
        {
            id: 2,
            title: "Panier",
            icon: PanierIcon,
            url: "Panier",
        },
        {
            id: 3,
            title: "Commandes",
            icon: LivraisonIcon,
            url: "Commandes",
        }
    ]

    return (
        <SafeAreaView>
            <Hero title={"Produo"} bgImg={Home}/>
            <FlatList
                style={{padding: 24, height : 600}}
                data={liensNavigation}
                renderItem={({item}) =>
                    <TouchableOpacity style={flatList.container} onPress={() => navigation.navigate(item.url)}>
                        <Image source={item.icon}/>
                        <Text style={flatList.text}>{item.title}</Text>
                    </TouchableOpacity>}
                keyExtractor={item => item.id}
            />
        </SafeAreaView>
    )
}

const flatList = StyleSheet.create({
    container: {
        height: 70,
        backgroundColor: '#02082B',
        borderRadius: 12,
        margin: 8,
        justifyContent: "space-evenly",
        flexDirection: "row",
        cursor: "pointer",
        alignItems: "center"
    },
    image: {
        resizeMode: "contain"
    },
    text: {
        color: "#fff",
        fontSize: 32,
        width: 200,
        textAlign: "center"
    }

})