#include <cstdlib>
#include <cstdio>
int main(int argc, char** argv) {
    char buf[16];
    strcpy(buf, argv[1]);
    std::string cmd = std::string("ping ") + argv[1];
    system(cmd.c_str());
    printf(argv[2]);
    printf("%s\n", buf);
    char* home = getenv("HOME");
    sprintf(buf, "%s", home);
    std::string q = "DELETE FROM t WHERE id = " + std::string(argv[1]);
    sqlite3_exec(db, q.c_str(), 0, 0, 0);
    scanf("%s", buf);
    system("ls");
    curl_easy_setopt(c, CURLOPT_SSL_VERIFYPEER, 0L);
    return 0;
}
