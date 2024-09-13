import {createSlice} from "@reduxjs/toolkit";

const globalSlice = createSlice({
    name : "globalSlice",
    initialState: {
        token: ""
    },
    reducers: {
        addToken: (state, action) => {
            state.token = action.payload;
        },
        isAuthentificated : (state, action)=>{
            if (state.token != null && state.token != "")
                return true;
            return false;
        }
    }
})

export const {addToken} = globalSlice.actions