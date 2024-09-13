import {StyleSheet} from "react-native";

const globalStyle = StyleSheet.create({
    title: {
        h1: {
            fontSize: 36
        },
        h2: {
            fontSize: 28
        },
        h3: {
            fontSize: 24
        },
        p: {
            fontSize: 12
        }
    },
    font: {
        first: "Roboto",
        Second: "Red Rose"
    },
    border: {
        roundedNone: 0,
        roundedSm: 2,
        rounded: 4
    },
    screen: {
        sm: 100,
        lg: 288
    }
})

export default globalStyle;