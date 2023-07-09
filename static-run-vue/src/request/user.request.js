import { request } from "@/request";

export const getLoginUserInfo = () => {
    return request.get('/user/getLoginUserInfo')
}