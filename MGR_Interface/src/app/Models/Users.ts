export class Users {
    id!:number;
    username!: string;
    password!: string;
    email?: string;
    role = "USER";

    constructor(){}
}

