export class SignUpRequest {

    username: string;

    password: string;

    role: string;


    constructor(data: any = {}) {

        this.username = data.username || '';

        this.password = data.password || '';

        this.role = data.role || '';

    }

}
