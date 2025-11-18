FROM node:21-slim

# Set working directory inside container
WORKDIR /backend

# Copy package.json and package-lock.json
COPY package*.json . 

# Install only production dependencies
RUN npm ci --only=production

# Copy the rest of the backend source code
COPY . . 

# Expose backend API port
EXPOSE 5000

# Start the Node.js server
CMD ["npm", "start"]
