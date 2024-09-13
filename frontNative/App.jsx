import React from 'react';
import {NavigationContainer} from '@react-navigation/native';
import HomePage from './src/views/HomePage';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';
import store from "./src/store/store"
import {Provider} from 'react-redux'
import VetementPage from "./src/views/vetements/VetementPage";
import {StyleSheet} from "react-native";
import PanierPage from "./src/views/PanierPage";
import CommandesPage from "./src/views/commandes/CommandesPage";
import LogPages from "./src/views/LogPages";


const App = () => {

    const Tab = createBottomTabNavigator();

    return (
        //<Provider store={store}>
        <NavigationContainer>
            <Tab.Navigator screenOptions={style.tabNavigation}>
                <Tab.Screen name={"Accueil"} component={HomePage}/>
                <Tab.Screen name={"Vêtements"} component={VetementPage}/>
                <Tab.Screen name={"Panier"} component={PanierPage}/>
                <Tab.Screen name={"Commandes"} component={CommandesPage}/>
                <Tab.Screen name={"Connexion"} component={LogPages}/>
            </Tab.Navigator>
        </NavigationContainer>
        //</Provider>
    );
};

export const style = StyleSheet.create({
    tabNavigation: {
        tabBarActiveBackgroundColor: '#1F2C78',
        tabBarInactiveBackgroundColor: '#02082B',
        tabBarInactiveTintColor: '#fff',
        tabBarActiveTintColor: "#D9D9D9",
        headerShown: false
    }
})

export default App;
