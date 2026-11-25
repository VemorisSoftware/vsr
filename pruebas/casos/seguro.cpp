#include <string>
int main(int argc, char** argv) {
    std::string nombre = argv[1];
    char buf[64];
    snprintf(buf, sizeof(buf), "%s", nombre.c_str());
    printf("%s\n", buf);
    std::cout << nombre << std::endl;
    return 0;
}
