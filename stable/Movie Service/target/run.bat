@echo off

echo ===== RUN START %date% %time% ===== >> logs.txt
java -jar FinalMovieService-1.0-SNAPSHOT.jar >> logs.txt 2>&1
echo ===== RUN END %date% %time% ===== >> logs.txt