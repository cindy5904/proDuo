import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import HomePage from './app/views/HomePage';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

const Tab = createBottomTabNavigator();

const App = () => {
    return (
        <NavigationContainer>
            <Tab.Navigator>
               <Tab.Screen name={"Home"} component={HomePage}/>
            </Tab.Navigator>
        </NavigationContainer>
    );
};

export default App;
