export interface IUser {
  id?: number;
  createdAt: Date;
  username: string;
  name: string;
  email: string;
  roles: IRole[];
}

export interface IRole {
  role: string;
}

export interface IOrder {
  id: number;
  createdAt: Date;
  name: string;
  serviceNumber: number;
  cost: number;
  userId: number;
  userEmail: string;
}
