CREATE DATABASE IF NOT EXISTS ai_interviewer CHARSET utf8mb4;
CREATE USER 'ai_interviewer_user'@'%' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON ai_interviewer.* TO 'ai_interviewer_user'@'%';