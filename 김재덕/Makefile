#
# Copyright (c) 2022-2023 jdeokkim
#
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
#
# The above copyright notice and this permission notice shall be included in all
# copies or substantial portions of the Software.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
# SOFTWARE.
#

.PHONY: all clean

_COLOR_BEGIN := $(shell tput setaf 13)
_COLOR_END := $(shell tput sgr0)

PROJECT_NAME := c-lab
PROJECT_FULL_NAME := jdeokkim/c-lab

PROJECT_PREFIX := $(_COLOR_BEGIN)$(PROJECT_FULL_NAME):$(_COLOR_END)

BINARY_PATH := bin
INCLUDE_PATH := include
SOURCE_PATH := src

SOURCES := $(wildcard $(SOURCE_PATH)/*.c)
TARGETS := $(SOURCES:$(SOURCE_PATH)/%.c=$(BINARY_PATH)/%.out)

HOST_PLATFORM := UNKNOWN

ifeq ($(OS),Windows_NT)
	ifeq "$(findstring ;,$(PATH))" ";"
		PROJECT_PREFIX := $(PROJECT_FULL_NAME):
	endif

# MINGW-W64 or MSYS2...?
	HOST_PLATFORM := WINDOWS
else
	UNAME = $(shell uname 2>/dev/null)

	ifeq ($(UNAME),Linux)
		HOST_PLATFORM = LINUX
	endif
endif

CC := gcc
CFLAGS := -D_DEFAULT_SOURCE -g $(INCLUDE_PATH:%=-I%) -lm -O2 -std=gnu99

PLATFORM := $(HOST_PLATFORM)

ifeq ($(PLATFORM),WINDOWS)
	TARGETS := $(SOURCES:$(SOURCE_PATH)/%.c=$(BINARY_PATH)/%.exe)

	ifneq ($(HOST_PLATFORM),WINDOWS)
		CC := x86_64-w64-mingw32-gcc
	endif
endif

all: pre-build build post-build

pre-build:
	@echo "$(PROJECT_PREFIX) Using: '$(CC)' to build all source files."
    
build: $(TARGETS)

$(BINARY_PATH)/%.out: $(SOURCE_PATH)/%.c
	@mkdir -p $(BINARY_PATH)
	@echo "$(PROJECT_PREFIX) Compiling: $@ (from $<)"
	@$(CC) $< -o $@ $(CFLAGS) $(LDFLAGS) $(LDLIBS) $(WEBFLAGS)
    
$(BINARY_PATH)/%.exe: $(SOURCE_PATH)/%.c
	@mkdir -p $(BINARY_PATH)
	@echo "$(PROJECT_PREFIX) Compiling: $@ (from $<)"
	@$(CC) $< -o $@ $(CFLAGS) $(LDFLAGS) $(LDLIBS) $(WEBFLAGS)
    
post-build:
	@echo "$(PROJECT_PREFIX) Build complete."

clean:
	@echo "$(PROJECT_PREFIX) Cleaning up."
	@rm -rf $(BINARY_PATH)/*.exe
	@rm -rf $(BINARY_PATH)/*.out
	@rm -rf $(SOURCE_PATH)/*.o