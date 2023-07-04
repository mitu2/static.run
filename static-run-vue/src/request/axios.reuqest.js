import axios from "axios";


export default {
    request: axios({
        // TODO: replace .env
        baseURL: 'http://api.local.static.run'
    })
}