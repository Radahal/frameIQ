
export interface Project {
  id: number,
  name: string,
  description: string,
}

export interface CreateProject {
  name: string,
  description: string,
}

export interface EditProject {
  name: string,
  description: string,
}
