# 🌍 Wanderlust Travel Blog App — DevOps Implementation

Production-Grade DevOps Workflow on a Real MERN Application

---

## 🧩 Tech Stack & Tools Used

| Category | Tools / Technologies |
|-----------|----------------------|
| **Version Control** | <img src="https://git-scm.com/images/logos/downloads/Git-Icon-1788C.png" width="22" align="center"/> **Git** &nbsp;&nbsp; <img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" width="22" align="center"/> **GitHub** |
| **CI/CD Platform** | <img src="https://img.icons8.com/color/48/jenkins.png" width="22" align="center"/> **Jenkins** |
| **Containerization** | <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original.svg" width="25" align="center"/> **Docker** |
| **Container Registry** | <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original.svg" width="25" align="center"/> **Docker Hub** |
| **Infrastructure / Orchestration** | <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/kubernetes/kubernetes-plain.svg" width="25" align="center"/> **Kubernetes (Kind on Azure VM)** |
| **Deployment Automation** | <img src="https://argo-cd.readthedocs.io/en/stable/assets/argo.png" width="25" align="center"/> **ArgoCD** |
| **Scripting** | <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/bash/bash-original.svg" width="25" align="center"/> **Shell Script (Bash)** |
| **Agent Setup** | <img src="https://img.icons8.com/color/48/azure-1.png" width="22" align="center"/> **Azure VM** |
| **Code Security Analysis** | <img src="https://img.icons8.com/?size=512&id=98957&format=png" width="25" align="center"/> **SonarQube** |


---

## 🔧 What’s Included / Implemented

### Docker & Containerization
- Multi-stage Dockerfiles for:
  - **Frontend (React)**
  - **Backend (Node.js + Express)**
- Official Docker images used for:
  - **MongoDB**
  - **Redis**
- Image builds follow best practices (minimized layers, appropriate tags, small runtime images).

### CI/CD — Jenkins 
- Jenkins pipelines built using a **Shared Library** to provide modular and repeatable pipeline stages.
- Pipeline stages include:
  1. Clean Workspace & Checkout
  2. **OWASP Dependency Check**
  3. **SonarQube** static code analysis and **Quality Gate** enforcement
  4. **Trivy** vulnerability and secret scanning
  5. Docker build and push to registry
  6. Update manifests (if needed) and trigger GitOps deployment

### DevSecOps
- Automated dependency vulnerability scanning (OWASP)
- Static analysis and quality gates (SonarQube)
- Container & filesystem scanning (Trivy)
- Pipeline fails safely if checks do not pass

### Kubernetes (Self-managed on Azure VM)
- Cluster: **Kind** (self-hosted) deployed on an **Azure Virtual Machine**
- Kubernetes manifests provided for:
  - Frontend Deployment + Service
  - Backend Deployment + Service
  - MongoDB StatefulSet/Deployment + PVC
  - Redis Deployment + Service
- Storage: **Azure Disk** backed **Persistent Volume (PV)** and **Persistent Volume Claim (PVC)** for MongoDB persistence

### GitOps with Argo CD
- Argo CD installed in-cluster to manage application manifests declaratively
- Automated sync, application health checks, and rollbacks
- Git acts as the single source of truth for deployments

---


## 🙌 Closing Thoughts

This project showcases a **complete, production-ready DevOps workflow** for a MERN travel blog application, combining **Jenkins CI/CD**, **Kubernetes orchestration**, and **Argo CD GitOps deployment**.  

It provided valuable **hands-on experience** in automating, securing, and scaling modern applications.  
The setup is fully extensible, and I continue to explore ways to integrate **cloud-native best practices**, **DevSecOps enhancements**, and **advanced infrastructure automation** in future projects.

---

⭐ *If you found this project interesting or valuable, don’t forget to give it a star on GitHub!*

