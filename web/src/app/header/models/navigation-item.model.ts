export enum NavigationItemType {
  DASHBOARD = "dashboard",
  PROJECT = "project",
  CONFIGURATION = "configuration",
  PROCESSING = "processing"
}

export class NavigationItem {
  private _type: NavigationItemType;
  private _name: string;
  private _url: string;
  private _active: boolean;

  constructor(type: NavigationItemType, name: string, url: string, active: boolean) {
    this._type = type;
    this._name = name;
    this._url = url;
    this._active = active;
  }

  get type(): NavigationItemType {
    return this._type;
  }

  set type(value: NavigationItemType) {
    this._type = value;
  }

  get name(): string {
    return this._name;
  }

  get url(): string {
    return this._url;
  }

  set name(value: string) {
    this._name = value;
  }

  set url(value: string) {
    this._url = value;
  }

  get active(): boolean {
    return this._active;
  }

  set active(value: boolean) {
    this._active = value;
  }
}
