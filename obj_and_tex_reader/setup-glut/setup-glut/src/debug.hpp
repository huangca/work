
#ifndef DEBUG_HPP
#define DEBUG_HPP

extern bool debug_output;

#define debug_print( stuff )                                                   \
if (debug_output == true) {                                                            \
	std::cout << "Debug: " << stuff << std::endl;                          \
}                                                                              \

#endif