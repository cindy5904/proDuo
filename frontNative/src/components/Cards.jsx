import React from 'react';
import {
    FlatList,
    ImageBackground,
    SafeAreaView, SectionList,
    StyleSheet,
    Text,
    TouchableOpacity,
    VirtualizedList
} from "react-native";

function Cards({data, navigation, title}) {
    return (
        <SafeAreaView>
            <SectionList
                sections={data}
                keyExtractor={(item, index) => item + index}
                renderItem={({item}) => (
                    <TouchableOpacity style={CardsStyle.container}>
                        <ImageBackground style={CardsStyle.bgImg} source={item.bgImg}>
                            <Text style={CardsStyle.text}>{item.title}</Text>
                        </ImageBackground>
                    </TouchableOpacity>
                )}
                renderSectionHeader={({section: title}) => (
                    <Text>{title}</Text>
                )}
            />
        </SafeAreaView>
    );
}

export default Cards;

const CardsStyle = StyleSheet.create({
    container: {
        alignItems: "center",
        justifyContent: "center",
        margin: 1,
        padding: 3,
    },
    bgImg: {
        margin: 5,
        opacity: .9,
        alignItems: "center",
        justifyContent: "flex-end",
        width: 180,
        height: 180,
        paddingBottom: 10
    },
    text: {
        backgroundColor: "#D9D9D9",
        padding: 5,
        opacity: .9
    }
})